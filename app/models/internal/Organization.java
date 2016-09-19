/**
 * Copyright 2016 Smartsheet.com
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
package models.internal;

import models.internal.impl.DefaultOrganization;

import java.util.UUID;

/**
 * Represents an organization. Organizations are separate entities for which hosts, alerts, and expressions
 * can be created.
 *
 * @author Brandon Arp (brandon dot arp at smartsheet dot com)
 */
public interface Organization {
    /**
     * Accessor for the uuid.
     *
     * @return The uuid.
     */
    UUID getId();

    /**
     * Default organization created by evolutions.
     */
    Organization DEFAULT = new DefaultOrganization.Builder()
            .setId(UUID.fromString("0eb03110-2a36-4cb1-861f-7375afc98b9b"))
            .build();
}
