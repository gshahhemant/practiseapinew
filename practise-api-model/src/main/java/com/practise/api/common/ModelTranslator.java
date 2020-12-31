package com.practise.api.common;

import java.util.List;

/**
 * @author hshah02
 *
 * @param <T>
 * @param <K>
 */
public interface ModelTranslator<T, K> {

	public K translate(T original);

	public List<K> translate(Iterable<T> original);
}
