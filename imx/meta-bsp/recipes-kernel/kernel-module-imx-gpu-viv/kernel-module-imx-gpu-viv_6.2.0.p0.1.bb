# Copyright (C) 2015-2016 Freescale Semiconductor

SUMMARY = "Kernel loadable module for Vivante GPU"
DESCRIPTION = "Builds the Vivante GPU kernel driver as a loadable kernel module, \
allowing flexibility to use an older kernel with a newer graphics release."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

SRC_URI = "${FSL_MIRROR}/${PN}-${PV}.tar.gz \
           file://kbuild.patch"
SRC_URI[md5sum] = "be433f9fd4da0655129798bdf4141b88"
SRC_URI[sha256sum] = "501ce8f70d71b5f3ea3c8ce160fe4b1fd976983f6e6f1fda96aa022f4cef433a"

inherit module

KERNEL_MODULE_AUTOLOAD = "galcore"
