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
package com.kgl.vulkan.dsls

import com.kgl.vulkan.enums.DescriptorType
import com.kgl.vulkan.enums.ShaderStage
import com.kgl.vulkan.handles.Sampler
import com.kgl.vulkan.utils.VkFlag

expect class DescriptorSetLayoutBindingBuilder {
	var binding: UInt

	var descriptorType: DescriptorType?

	var stageFlags: VkFlag<ShaderStage>?
}

expect class DescriptorSetLayoutBindingsBuilder {
	fun binding(immutableSamplers: Collection<Sampler>, block: DescriptorSetLayoutBindingBuilder.() -> Unit = {})
	fun binding(descriptorCount: UInt = 1U, block: DescriptorSetLayoutBindingBuilder.() -> Unit)
}

