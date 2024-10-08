package org.vicary;

import java.util.*;

public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findBlockByColor(color, blocks);
    }

    private Optional<Block> findBlockByColor(String color, List<Block> blocks) {
        if (blocks == null || color == null)
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
        return findBlocksByMaterial(material, blocks);
    }

    private List<Block> findBlocksByMaterial(String material, List<Block> blocks) {
        if (blocks == null || material == null)
            return Collections.emptyList();

        List<Block> foundBlocks = new ArrayList<>();
        for (Block block : blocks) {
            if (block.material() != null && block.material().equals(material))
                foundBlocks.add(block);
            if (block instanceof CompositeBlock compositeBlock)
                foundBlocks.addAll(findBlocksByMaterial(material, compositeBlock.blocks()));
        }
        return foundBlocks;
    }


    @Override
    public int count() {
        return count(blocks);
    }

    private int count(List<Block> blocks) {
        int amount = 0;
        if (blocks == null)
            return amount;

        for (Block block : blocks) {
            amount++;
            if (block instanceof CompositeBlock compositeBlock)
                amount += count(compositeBlock.blocks());
        }
        return amount;
    }
}