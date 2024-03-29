SUMMARY  = "The SPIR-V Tools project provides an API and commands for \
processing SPIR-V modules"
DESCRIPTION = "The project includes an assembler, binary module parser, \
disassembler, validator, and optimizer for SPIR-V."
LICENSE  = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
SECTION = "graphics"

S = "${WORKDIR}/git"
DEST_DIR = "${S}/external" 
SRC_URI = "git://github.com/KhronosGroup/SPIRV-Tools.git;name=spirv-tools \
	file://0001-tools-lesspipe-Allow-generic-shell.patch \
	file://0001-Avoid-GCC8-warning-in-text_handler.cpp.-2197.patch \
	git://github.com/KhronosGroup/SPIRV-Headers.git;name=spirv-headers;destsuffix=${DEST_DIR}/spirv-headers \
"
SRCREV_spirv-tools = "9d699f6d4038f432c55310d5d0b4a6d507c1b686"
SRCREV_spirv-headers = "a5d33a253b47e183e54dcb9cf0e8ee729e88f6db"

inherit cmake python3native

do_install_append() {
	install -d ${D}/${includedir}/SPIRV
	install -m 0644 ${DEST_DIR}/spirv-headers/include/spirv/unified1/* ${D}/${includedir}/SPIRV
}

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"
