/**
 * Copyright 2018 Smartsheet.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arpnetworking.metrics.portal.organizations;

import models.internal.Organization;
import play.mvc.Http;

/**
 * Provides organizations to use for multi-tenancy.
 *
 * @author Brandon Arp (brandon dot arp at smartsheet dot com)
 */
public interface OrganizationProvider {
    /**
     * Get the organization in the current request.
     *
     * @param request request that serves as the context
     * @return the organization to use for the request
     */
    Organization getOrganization(Http.Request request);
}
