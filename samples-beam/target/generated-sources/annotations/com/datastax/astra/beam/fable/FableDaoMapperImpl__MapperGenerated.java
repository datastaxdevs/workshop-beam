package com.datastax.astra.beam.fable;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.internal.mapper.DaoCacheKey;
import com.datastax.oss.driver.internal.mapper.DefaultMapperContext;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Do not instantiate this class directly, use {@link FableDaoMapperBuilder} instead.
 *
 * <p>Generated by the DataStax driver mapper, do not edit directly.
 */
@SuppressWarnings("all")
public class FableDaoMapperImpl__MapperGenerated implements FableDaoMapper {
  private final DefaultMapperContext context;

  private final ConcurrentMap<DaoCacheKey, FableDao> getFableDaoCache = new ConcurrentHashMap<>();

  public FableDaoMapperImpl__MapperGenerated(DefaultMapperContext context) {
    this.context = context;
  }

  @Override
  public FableDao getFableDao(CqlIdentifier keyspace) {
    DaoCacheKey key = new DaoCacheKey(keyspace, (CqlIdentifier)null, null, null);
    return getFableDaoCache.computeIfAbsent(key, k -> FableDaoImpl__MapperGenerated.init(context.withDaoParameters(k.getKeyspaceId(), k.getTableId(), k.getExecutionProfileName(), k.getExecutionProfile())));
  }
}