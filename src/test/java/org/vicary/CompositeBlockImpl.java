package org.vicary;

import java.util.List;

record CompositeBlockImpl(List<Block> blocks, String color, String material) implements CompositeBlock {
}
