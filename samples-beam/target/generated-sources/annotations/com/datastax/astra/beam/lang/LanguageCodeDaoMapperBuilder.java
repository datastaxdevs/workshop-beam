package com.datastax.astra.beam.lang;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.internal.mapper.DefaultMapperContext;
import java.lang.Override;
import java.lang.SuppressWarnings;

/**
 * Builds an instance of {@link LanguageCodeDaoMapper} wrapping a driver {@link CqlSession}.
 *
 * <p>Generated by the DataStax driver mapper, do not edit directly.
 */
@SuppressWarnings("all")
public class LanguageCodeDaoMapperBuilder extends MapperBuilder<LanguageCodeDaoMapper> {
  public LanguageCodeDaoMapperBuilder(CqlSession session) {
    super(session);
  }

  @Override
  public LanguageCodeDaoMapper build() {
    DefaultMapperContext context = new DefaultMapperContext(session, defaultKeyspaceId, defaultExecutionProfileName, defaultExecutionProfile, customState);
    return new LanguageCodeDaoMapperImpl__MapperGenerated(context);
  }
}
