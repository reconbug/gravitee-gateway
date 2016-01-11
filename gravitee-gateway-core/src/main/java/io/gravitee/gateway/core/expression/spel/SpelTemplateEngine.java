/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.gateway.core.expression.spel;

import io.gravitee.gateway.api.expression.TemplateEngine;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author David BRASSELY (brasseld at gmail.com)
 */
public class SpelTemplateEngine implements TemplateEngine {

    private SpelTemplateContext templateContext;

    @Override
    public String convert(String expression) {
        return new SpelExpressionParser()
                .parseExpression(expression, new TemplateParserContext())
                .getValue(getTemplateContext().getContext(), String.class);
    }

    @Override
    public SpelTemplateContext getTemplateContext() {
        if (templateContext == null) {
            templateContext = new SpelTemplateContext();
        }

        return templateContext;
    }
}