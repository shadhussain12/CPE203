public class AnimationAction implements Action{
    private AnimationEntity entity;
    private WorldModel world;
    private ImageStore imageStore;
    private int repeatCount;

    public AnimationAction(AnimationEntity entity, WorldModel world, ImageStore imageStore, int repeatCount){
        this.entity = entity;
        this.world = world;
        this.imageStore = imageStore;
        this.repeatCount = repeatCount;
    }

    @Override
    public void executeAction(EventScheduler scheduler) {
        this.entity.nextImage();
        if (this.repeatCount != 1) {
            scheduler.scheduleEvent(this.entity,
                    CreateAction.createAnimationAction(this.entity, Math.max(this.repeatCount - 1, 0)),
                    this.entity.getAnimationPeriod());
        }
    }
}
