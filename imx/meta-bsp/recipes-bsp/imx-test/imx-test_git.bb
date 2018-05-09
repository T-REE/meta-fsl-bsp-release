# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP

include recipes-bsp/imx-test/imx-test.inc

PV = "7.0+${SRCPV}"

SRCBRANCH = "imx_4.9.88_imx8qxp_beta2"
IMXTEST_SRC ?= "git://source.codeaurora.org/external/imx/imx-test.git;protocol=https"
SRC_URI = "${IMXTEST_SRC};branch=${SRCBRANCH}"
SRC_URI_append = " file://memtool_profile "

SRCREV = "be2b8e60d85074c1ed24afa3c4d35ffb7d28b74b"

S = "${WORKDIR}/git"

DEPENDS_append        = " alsa-lib libdrm"
DEPENDS_append_mx7ulp = " virtual/kernel imx-lib"
DEPENDS_append_mx8    = " virtual/kernel"
DEPENDS_append_imxvpu = " virtual/imxvpu"

PLATFORM_mx6sll = "IMX6SL"
PLATFORM_mx7ulp  = "IMX7D"
PLATFORM_mx8 = "IMX8"

IMX_HAS_VPU         = "false"
IMX_HAS_VPU_imxvpu  = "true"
EXTRA_OEMAKE       += "HAS_VPU=${IMX_HAS_VPU}"

PARALLEL_MAKE="-j 1"

do_install_append() {
    install -d -m 0755 ${D}/home/root/
    install -m 0644 ${WORKDIR}/memtool_profile ${D}/home/root/.profile
}

# Avoid race condition between tasks. This should be upstreamed to meta-freescale.
addtask make_scripts after do_configure before do_compile

FILES_${PN} += " /home/root/.profile "

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

EXTRA_OEMAKE += "SDKTARGETSYSROOT=${STAGING_DIR_HOST}"
