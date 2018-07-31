/*
 * Copyright (c) 2018 Regents of the University of Minnesota.
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

package edu.umn.biomedicus.framework;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import edu.umn.biomedicus.annotations.ProcessorScoped;

import java.nio.file.Path;

/**
 *
 */
final class BiomedicusModule extends AbstractModule {

  private final Path homePath;

  public BiomedicusModule(Path homePath) {
    this.homePath = homePath;
  }

  @Override
  protected void configure() {
    bindScope(ProcessorScoped.class, BiomedicusScopes.PROCESSOR_SCOPE);
    bind(Key.get(Path.class, new SettingImpl("biomedicus.paths.home"))).toInstance(homePath);
  }
}
