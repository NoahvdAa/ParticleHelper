package com.owen1212055.particlehelper.api.particle.types.common.blockdata;

import com.owen1212055.particlehelper.api.particle.compiled.*;
import com.owen1212055.particlehelper.api.particle.types.*;
import com.owen1212055.particlehelper.api.type.*;
import org.bukkit.block.data.*;

public class MultiBlockDataParticle extends AbstractMultiParticle implements BlockDataParticle {

    private BlockData blockData;

    public MultiBlockDataParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public BlockData getBlockData() {
        return this.blockData;
    }

    @Override
    public void setBlockData(BlockData data) {
        this.blockData = data;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.data = blockData;

        return simpleCompiledParticle.compileSender();
    }
}