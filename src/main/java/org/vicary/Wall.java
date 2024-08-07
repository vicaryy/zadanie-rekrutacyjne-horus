package org.vicary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null)
            return Optional.empty();

        return findBlockByColor(color, this.blocks);
    }

    private Optional<Block> findBlockByColor(String color, List<Block> blocks) {
        if (blocks == null)
            return Optional.empty();

        for (Block block : blocks) {
            if (block.color() != null && block.color().equals(color))
                return Optional.of(block);
            if (block instanceof CompositeBlock compositeBlock) {
                Optional<Block> foundBlock = findBlockByColor(color, compositeBlock.blocks());
                if (foundBlock.isPresent())
                    return foundBlock;
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return findBlocksByMaterial(material, new ArrayList<>(), this.blocks);
    }

    private List<Block> findBlocksByMaterial(String material, List<Block> foundBlocks, List<Block> blocks) {
        for (Block block : blocks) {
            if (block.material() != null && block.material().equals(material))
                foundBlocks.add(block);
            if (block instanceof CompositeBlock compositeBlock)
                findBlocksByMaterial(material, foundBlocks, compositeBlock.blocks());
        }
        return foundBlocks;
    }

    @Override
    public int count() {
        return count(this.blocks, 0);
    }

    private int count(List<Block> blocks, int count) {
        
        return count;
    }
}
















