/**
 * Copyright 2015 Groupon.com
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
package models.internal.impl;

import com.arpnetworking.logback.annotations.LogValue;
import com.arpnetworking.steno.LogValueMapFactory;
import models.internal.QueryResult;

import java.util.List;
import java.util.Optional;

/**
 * Default internal model implementation for a query result.
 *
 * @param <T> The result value type.
 *
 * @author Ville Koskela (ville dot koskela at inscopemetrics dot com)
 */
public final class DefaultQueryResult<T> implements QueryResult<T> {

    /**
     * Public constructor.
     *
     * @param values The <code>List</code> of <code>Host</code> instances.
     * @param total The total number of matching <code>Host</code> instances.
     */
    public DefaultQueryResult(final List<? extends T> values, final long total) {
        _values = values;
        _total = total;
        _etag = Optional.empty();
    }

    /**
     * Public constructor.
     *
     * @param values The <code>List</code> of <code>Host</code> instances.
     * @param total The total number of matching <code>Host</code> instances.
     * @param etag The etag.
     */
    public DefaultQueryResult(final List<? extends T> values, final long total, final String etag) {
        _values = values;
        _total = total;
        _etag = Optional.of(etag);
    }

    @Override
    public List<? extends T> values() {
        return _values;
    }

    @Override
    public long total() {
        return _total;
    }

    @Override
    public Optional<String> etag() {
        return _etag;
    }

    /**
     * Generate a Steno log compatible representation.
     *
     * @return Steno log compatible representation.
     */
    @LogValue
    public Object toLogValue() {
        return LogValueMapFactory.builder(this)
                .put("values", _values)
                .put("total", _total)
                .put("etag", _etag)
                .build();
    }

    @Override
    public String toString() {
        return toLogValue().toString();
    }

    private final List<? extends T> _values;
    private final long _total;
    private final Optional<String> _etag;
}
