/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.templateparser.xmlsax;

import java.util.List;

import org.thymeleaf.dom.Document;
import org.thymeleaf.dom.Node;

/**
 * <p>
 *   Parses XML documents, using a standard SAX parser.
 * </p>
 * 
 * <p>
 *   This implementation populates tree nodes with detailed location 
 *   information (document name and line number).
 * </p>
 * 
 * @since 2.0.0
 * 
 * @author Guven Demir
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class XhtmlAndHtml5NonValidatingSAXTemplateParser extends AbstractNonValidatingSAXTemplateParser {


    // This fragment start is valid for both HTML5 and non-validating XHTML (being a fragment and non-validating,
    // there is no need to add DTDs).
    private static final String FRAGMENT_WRAP_START = "<!DOCTYPE html>\n<html><body><div>";
    private static final String FRAGMENT_WRAP_END = "</div></body></html>";

    
    
    public XhtmlAndHtml5NonValidatingSAXTemplateParser(final int poolSize) {
        super(poolSize);
    }


    @Override
    protected String wrapFragment(final String fragment) {
        return FRAGMENT_WRAP_START + fragment + FRAGMENT_WRAP_END;
    }

    
    @Override
    protected List<Node> unwrapFragment(final Document document) {
        return document.getFirstElementChild().getFirstElementChild().getFirstElementChild().getChildren();
    }
    
}
