SUMMARY = "AVaRICE interfaces GDB with AVR debugging tools"
HOMEPAGE = "http://avarice.sourceforge.net/"
SECTION = "devel"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

inherit autotools gettext

# hidapi?
DEPENDS = " \
    libusb-compat \
"

SRC_URI = "git://github.com/schnitzeltony/avarice.git;protocol=https"
SRCREV = "ec0c1b4cad7206f943547a1ceef2f478bcb68155"
S = "${WORKDIR}/git/${BPN}"
PV = "2.13+git${SRCPV}"

do_install_append() {
    # fix shebang in ice-gdb script
    sed -i 's:#!.*perl:#!/usr/bin/perl:' ${D}${bindir}/ice-gdb
}

RDEPENDS_${PN} += "perl"
RRECOMMENDS_${PN} += "avr-udev-rules"
