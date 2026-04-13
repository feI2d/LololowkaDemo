package dev.feid1337.content.entity.lololowka;

import org.zeith.hammeranims.api.geometry.IGeometryContainer;
import org.zeith.hammerlib.annotations.RegistryName;
import org.zeith.hammerlib.annotations.SimplyRegister;

@SimplyRegister
public interface LololowkaGeo {

    @RegistryName("lololowka")
    IGeometryContainer geo = IGeometryContainer.create();

}
