package org.vicary;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class WallStream implements Structure {
    private final List<Block> blocks;

    public WallStream(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (blocks == null)
            return Optional.empty();
        return getStreamOfBlocks(blocks).filter(block -> block.color() != null && block.color().equals(color)).findFirst();
    }


    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (blocks == null)
            return Collections.emptyList();
        return getStreamOfBlocks(blocks).filter(block -> block.material() != null && block.material().equals(material)).toList();
    }

    @Override
    public int count() {
        if (blocks == null)
            return 0;
        return (int) getStreamOfBlocks(blocks).count();
    }

    // bez pomocy internetu nie dałbym rady tego zrobić
    private Stream<Block> getStreamOfBlocks(List<Block> blocks) {
        return blocks.stream().flatMap(block -> {
            if (block instanceof CompositeBlock compositeBlock)
                return Stream.concat(Stream.of(block), getStreamOfBlocks(compositeBlock.blocks()));
            return Stream.of(block);
        });
    }
}
