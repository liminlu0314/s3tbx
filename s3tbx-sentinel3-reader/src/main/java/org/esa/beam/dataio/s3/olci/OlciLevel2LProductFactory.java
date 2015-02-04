package org.esa.beam.dataio.s3.olci;

import org.esa.beam.dataio.s3.Sentinel3ProductReader;
import org.esa.beam.dataio.s3.slstr.SlstrNetcdfReaderFactory;
import org.esa.beam.dataio.s3.util.S3NetcdfReader;
import org.esa.beam.framework.datamodel.Product;

import java.io.File;
import java.io.IOException;

/**
 * @author Tonio Fincke
 */
public class OlciLevel2LProductFactory extends OlciProductFactory {

    public OlciLevel2LProductFactory(Sentinel3ProductReader productReader) {
        super(productReader);
    }

    @Override
    protected String getValidExpression() {
        return "!LQSF.INVALID";
    }

    @Override
    protected void setAutoGrouping(Product[] sourceProducts, Product targetProduct) {
        targetProduct.setAutoGrouping("IWV:OGVI:OTCI:RC681:RC865:atmospheric_temperature_profile:" +
                                              "lambda0:FWHM:solar_flux");
    }

}