/**
 * Copyright [2019] [Dominic Fischer]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kgl.vulkan.enums

import com.kgl.vulkan.utils.VkEnum
import cvulkan.*

actual enum class QueryType(override val value: VkQueryType) : VkEnum<QueryType> {
	OCCLUSION(VK_QUERY_TYPE_OCCLUSION),

	ACCELERATION_STRUCTURE_COMPACTED_SIZE_NV(VK_QUERY_TYPE_ACCELERATION_STRUCTURE_COMPACTED_SIZE_NV),

	PIPELINE_STATISTICS(VK_QUERY_TYPE_PIPELINE_STATISTICS),

	TIMESTAMP(VK_QUERY_TYPE_TIMESTAMP),

	TRANSFORM_FEEDBACK_STREAM_EXT(VK_QUERY_TYPE_TRANSFORM_FEEDBACK_STREAM_EXT);

	companion object {
		private val enumLookUpMap: Map<UInt, QueryType> = enumValues<QueryType>().associateBy({
			it.value
		})

		fun from(value: VkQueryType): QueryType = enumLookUpMap[value]!!
	}
}

