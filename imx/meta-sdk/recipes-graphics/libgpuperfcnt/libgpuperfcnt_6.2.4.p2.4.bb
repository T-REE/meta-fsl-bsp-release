DESCRIPTION = "A library to retrieve i.MX GPU performance data"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=6dfb32a488e5fd6bae52fbf6c7ebb086"

SRC_URI[arm-fb.md5sum] = "fb6fcbbefdca5db5e5cca123600ca90c"
SRC_URI[arm-fb.sha256sum] = "debc4ef4b85a21c7234521e7a6a5e6c541d2918cdaf339ed3d2d8536a82ae715"

SRC_URI[arm-wayland.md5sum] = "76992d90205d8696519b08e34e7159c5"
SRC_URI[arm-wayland.sha256sum] = "0241f7aff07c98bc4b097fadc42e7123c70445548473716b8727c1e9d8e1d580"

SRC_URI[arm-x11.md5sum] = "bebcd91e292656910fe19d45feb069dd"
SRC_URI[arm-x11.sha256sum] = "b6ddb339b6e8ba837be363abc6261ecfdf610ec81244c36f1a14c6797769e1ba"

SRC_URI[aarch64-fb.md5sum] = "fdbbf9912664dd51f4fcee428364ce19"
SRC_URI[aarch64-fb.sha256sum] = "8d92f26c7b8fbabcf32854ebfa3900019624daad05742b0cfb86b2fbc0e0b9cf"

SRC_URI[aarch64-wayland.md5sum] = "b63b0a0a675c7d82d347d6ce8fa062b4"
SRC_URI[aarch64-wayland.sha256sum] = "545cab1a8a0d3de3d7f4a889d61805a0965263b3ea1a686a81706b0a845e8e2f"

SRC_URI[aarch64-x11.md5sum] = "18d9bebaa67e5e5499bfdd9d5028f476"
SRC_URI[aarch64-x11.sha256sum] = "a85b24a6c06caa4cc5c1badf63d5462bfd5f697e60bc7a1b3a333ef0205d44b7"

inherit fsl-eula-unpack2 fsl-eula-graphics

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

RDEPENDS_${PN} = "imx-gpu-viv"

# Compatible only with i.MX with GPU
COMPATIBLE_MACHINE        = "(^$)"
COMPATIBLE_MACHINE_imxgpu = "${MACHINE}"