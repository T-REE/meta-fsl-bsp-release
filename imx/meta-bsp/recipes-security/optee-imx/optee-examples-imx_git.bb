SUMMARY = "OP-TEE examples"
HOMEPAGE = "https://github.com/linaro-swg/optee_examples"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=cd95ab417e23b94f381dafc453d70c30"

DEPENDS = "optee-client-imx optee-os-imx python-pycrypto-native"

inherit pythonnative

SRC_URI = "git://github.com/linaro-swg/optee_examples.git"
SRCREV = "master"

S = "${WORKDIR}/git"

OPTEE_CLIENT_EXPORT = "${STAGING_DIR_HOST}/usr"
TEEC_EXPORT = "${STAGING_DIR_HOST}/usr"
TA_DEV_KIT_DIR = "${STAGING_INCDIR}/optee/export-user_ta_arm64"
ARCH="arm64"

EXTRA_OEMAKE = " TA_DEV_KIT_DIR=${TA_DEV_KIT_DIR} \
                 OPTEE_CLIENT_EXPORT=${OPTEE_CLIENT_EXPORT} \
                 TEEC_EXPORT=${TEEC_EXPORT} \
                 HOST_CROSS_COMPILE=${HOST_PREFIX} \
                 TA_CROSS_COMPILE=${HOST_PREFIX} \
                 ARCH=${ARCH} \
                 V=1 \
               "

do_compile() {
    oe_runmake
}

do_install () {
    mkdir -p ${D}/lib/optee_armtz
    mkdir -p ${D}/usr/bin

#    install -D -p -m0755 ${S}/out/ca/* ${D}/usr/bin/
    install -m0755 ${S}/out/ca/* ${D}/usr/bin/
#    install -D -p -m0444 ${S}/out/ta/* ${D}/lib/optee_armtz/
    install -m0444 ${S}/out/ta/* ${D}/lib/optee_armtz/
}

FILES_${PN} += "/usr/bin/ /lib*/optee_armtz/"

# Imports machine specific configs from staging to build
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(mx8)"

# skio QA issue
#  QA Issue: No GNU_HASH in the elf binary
# Ref:
#       https://forums.xilinx.com/t5/Embedded-Linux/No-GNU-HASH/td-p/832423
#       https://www.lynxbee.com/how-to-fix-error-do_package_qa-qa-issue-no-gnu_hash-in-the-elf-binary/
INSANE_SKIP_${PN} = "ldflags"
