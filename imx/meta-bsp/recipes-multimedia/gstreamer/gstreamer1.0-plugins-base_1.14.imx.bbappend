DEPENDS_append_imxgpu2d = " virtual/libg2d"

FILESEXTRAPATHS_prepend := "${BSPDIR}/sources/meta-freescale/recipes-multimedia/gstreamer/${PN}-1.14.imx:"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCBRANCH = "MM_04.04.06_1906_L4.19.35"
SRCREV = "5e8cc757e4fec72ee007ac12fab2d1333fce1dc9"

PV = "1.14.4.imx"

# opengl packageconfig factored out to make it easy for distros
# and BSP layers to pick either (desktop) opengl, gles2, or no GL
PACKAGECONFIG_GL ?= "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 egl', '', d)}"

PACKAGECONFIG_append = " \
    ${PACKAGECONFIG_GL} \
    gio-unix-2.0 zlib \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland egl', '', d)} \
"
PACKAGECONFIG[egl]          = "--enable-egl,--disable-egl,virtual/egl"
PACKAGECONFIG[gio-unix-2.0] = "--enable-gio_unix_2_0,--disable-gio_unix_2_0,glib-2.0"
PACKAGECONFIG[gles2]        = "--enable-gles2,--disable-gles2,virtual/libgles2"
PACKAGECONFIG[opengl]       = "--enable-opengl,--disable-opengl,virtual/libgl libglu"
PACKAGECONFIG[wayland]      = "--enable-wayland,--disable-wayland,wayland-native wayland wayland-protocols libdrm"
PACKAGECONFIG[zlib]         = "--enable-zlib,--disable-zlib,zlib"

EXTRA_OECONF_append = " --disable-opengl --enable-wayland"

