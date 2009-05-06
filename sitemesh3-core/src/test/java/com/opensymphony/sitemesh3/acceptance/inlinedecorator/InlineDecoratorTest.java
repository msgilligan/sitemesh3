package com.opensymphony.sitemesh3.acceptance.inlinedecorator;

import com.opensymphony.sitemesh3.acceptance.AcceptanceTestSuiteBuilder;
import com.opensymphony.sitemesh3.config.SiteMeshConfig;
import com.opensymphony.sitemesh3.config.SiteMeshFilter;
import com.opensymphony.sitemesh3.webapp.WebAppContext;
import com.opensymphony.sitemesh3.webapp.WebEnvironment;
import junit.framework.Test;

/**
 * Tests inline decorators using the &lt;sitemesh:decorate&;gt; tag.
 *
 * @author Joe Walnes
 * @see AcceptanceTestSuiteBuilder
 */
public class InlineDecoratorTest {

    public static Test suite() throws Exception {
        String suiteName = "inlinedecorator";

        WebEnvironment webEnvironment = new WebEnvironment.Builder()
                .addFilter("/*", new SiteMeshFilter(new SiteMeshConfig<WebAppContext>()
                        .addDecoratorPath("/*", "/page-decorator.html")))
                .setRootDir(AcceptanceTestSuiteBuilder.getInputDir(suiteName))
                .create();

        return AcceptanceTestSuiteBuilder.buildWebAppSuite(suiteName, webEnvironment);
    }

}
