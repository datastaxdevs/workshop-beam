package com.datastax.astra.dataflow.domains;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.internal.mapper.DaoCacheKey;
import com.datastax.oss.driver.internal.mapper.DefaultMapperContext;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Do not instantiate this class directly, use {@link LanguageCodeDaoMapperBuilder} instead.
 *
 * <p>Generated by the DataStax driver mapper, do not edit directly.
 */
@SuppressWarnings("all")
public class LanguageCodeDaoMapperImpl__MapperGenerated implements LanguageCodeDaoMapper {
  private final DefaultMapperContext context;

  private final ConcurrentMap<DaoCacheKey, LanguageCodeDao> getLanguageCodeDaoCache = new ConcurrentHashMap<>();

  public LanguageCodeDaoMapperImpl__MapperGenerated(DefaultMapperContext context) {
    this.context = context;
  }

  @Override
  public LanguageCodeDao getLanguageCodeDao(CqlIdentifier keyspace) {
    DaoCacheKey key = new DaoCacheKey(keyspace, (CqlIdentifier)null, null, null);
    return getLanguageCodeDaoCache.computeIfAbsent(key, k -> LanguageCodeDaoImpl__MapperGenerated.init(context.withDaoParameters(k.getKeyspaceId(), k.getTableId(), k.getExecutionProfileName(), k.getExecutionProfile())));
  }
}