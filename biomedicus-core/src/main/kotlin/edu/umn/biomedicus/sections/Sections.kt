/*
 * Copyright (c) 2017 Regents of the University of Minnesota.
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

package edu.umn.biomedicus.sections

import edu.umn.nlpengine.Label

data class Section(
        override val startIndex: Int,
        override val endIndex: Int,
        val kind: String?
): Label {
    constructor(label: Label, kind: String?): this(label.startIndex, label.endIndex, kind)
}

data class SectionTitle(override val startIndex: Int, override val endIndex: Int): Label {
    constructor(label: Label): this(label.startIndex, label.endIndex)
}

data class SectionContent(override val startIndex: Int, override val endIndex: Int): Label