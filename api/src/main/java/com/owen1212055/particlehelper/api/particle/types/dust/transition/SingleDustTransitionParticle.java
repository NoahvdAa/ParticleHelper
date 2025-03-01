package com.owen1212055.particlehelper.api.particle.types.dust.transition;

import com.owen1212055.particlehelper.api.particle.compiled.CompiledParticle;
import com.owen1212055.particlehelper.api.particle.compiled.SimpleCompiledParticle;
import com.owen1212055.particlehelper.api.particle.types.dust.SingleDustParticle;
import com.owen1212055.particlehelper.api.type.ParticleType;
import org.bukkit.Color;
import org.bukkit.Particle;

public class SingleDustTransitionParticle extends SingleDustParticle implements TransitionDustParticle {

    private Color fade = Color.RED;

    public SingleDustTransitionParticle(ParticleType<?, ?> particleType) {
        super(particleType);
    }

    @Override
    public Color getFadeColor() {
        return this.fade;
    }

    @Override
    public void setFadeColor(Color color) {
        this.fade = color;
    }

    @Override
    public CompiledParticle compile() {
        SimpleCompiledParticle simpleCompiledParticle = new SimpleCompiledParticle(this);
        simpleCompiledParticle.offsetX = this.xVelocity;
        simpleCompiledParticle.offsetY = this.yVelocity;
        simpleCompiledParticle.offsetZ = this.zVelocity;
        simpleCompiledParticle.speed = 1; // Keep speed constant
        simpleCompiledParticle.data = new Particle.DustTransition(color, fade, size);

        return simpleCompiledParticle.compileSender();
    }
}
