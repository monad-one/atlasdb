/*
 * Copyright 2016 Palantir Technologies, Inc. All rights reserved.
 *
 * Licensed under the BSD-3 License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.palantir.atlasdb.keyvalue.cassandra;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CassandraApiVersionTest {
    @Test public void
    version_19_36_0_does_not_support_cas() {
        CassandraApiVersion version = new CassandraApiVersion("19.36.0");
        assertThat(version.supportsCheckAndSet(), is(false));
    }

    @Test public void
    version_19_37_0_supports_cas() {
        CassandraApiVersion version = new CassandraApiVersion("19.37.0");
        assertThat(version.supportsCheckAndSet(), is(true));
    }

    @Test public void
    version_19_38_0_supports_cas() {
        CassandraApiVersion version = new CassandraApiVersion("19.38.0");
        assertThat(version.supportsCheckAndSet(), is(true));
    }

    @Test public void
    version_20_1_0_supports_cas() {
        CassandraApiVersion version = new CassandraApiVersion("20.1.0");
        assertThat(version.supportsCheckAndSet(), is(true));
    }

    @Test public void
    version_18_40_0_does_not_support_cas() {
        CassandraApiVersion version = new CassandraApiVersion("18.40.0");
        assertThat(version.supportsCheckAndSet(), is(false));
    }

    @Test public void
    version_20_40_1_supports_cas() {
        CassandraApiVersion version = new CassandraApiVersion("20.40.1");
        assertThat(version.supportsCheckAndSet(), is(true));
    }

    @Test(expected = UnsupportedOperationException.class) public void
    invalid_version_strings_throw_an_error() {
        new CassandraApiVersion("20_4.1");
    }

}
