/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.markup.renderStrategy;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;


/**
 * Mock page for testing.
 */
public class SimplePanel1 extends Panel
{
	private static final long serialVersionUID = 1L;

	/**
	 * Construct.
	 * 
	 * @param id
	 * @param prefix
	 */
	public SimplePanel1(final String id)
	{
		super(id);
		addAll("");
		addAll("pre_");
	}

	private void addAll(final String prefix)
	{
		MarkupContainer container1 = addXXX(prefix + "container1", this);
		MarkupContainer container2 = addXXX(prefix + "container2", this);
		MarkupContainer container2_1 = addXXX(prefix + "container2_1", container2);
		MarkupContainer container3 = addXXX(prefix + "container3", this);
		MarkupContainer container3_1 = addXXX(prefix + "container3_1", container3);
		MarkupContainer container3_1_1 = addXXX(prefix + "container3_1_1", container3_1);

		MarkupContainer container4 = addXXX(prefix + "container4", this);
		MarkupContainer container4_1 = addXXX(prefix + "container4_1", container4);
		MarkupContainer container4_2 = addXXX(prefix + "container4_2", container4);
		MarkupContainer container4_2_1 = addXXX(prefix + "container4_2_1", container4_2);
		MarkupContainer container4_3 = addXXX(prefix + "container4_3", container4);
		MarkupContainer container4_3_1 = addXXX(prefix + "container4_3_1", container4_3);
		MarkupContainer container4_3_1_1 = addXXX(prefix + "container4_3_1_1", container4_3_1);
	}

	private MarkupContainer addXXX(final String id, final MarkupContainer parent)
	{
		MarkupContainer container = new WebMarkupContainer(id);
		parent.add(container);
		container.add(new AbstractBehavior()
		{
			@Override
			public void renderHead(IHeaderResponse response)
			{
				response.renderCSSReference(id + ".css");
			}
		});
		return container;
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		response.renderCSSReference(getClass().getSimpleName() + ".css");
	}
}
