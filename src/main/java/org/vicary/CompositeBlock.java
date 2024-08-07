package org.vicary;

import java.util.List;

interface CompositeBlock extends Block {
    List<Block> blocks();
}
