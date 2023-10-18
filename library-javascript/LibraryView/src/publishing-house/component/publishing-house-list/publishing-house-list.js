window.addEventListener("load", () => {
  new PublishingHouseListComponent(
    new DataBinder(),
    new PublishingHouseService()
  ).onInit();
});

class PublishingHouseListComponent {
  publishingHouses;

  publishingHouseService;

  dataBinder;

  constructor(dataBinder, publishingHouseService) {
    this.dataBinder = dataBinder;
    this.publishingHouseService = publishingHouseService;
  }

  onInit() {
    this.publishingHouseService.getPublishingHouses().then((data) => {
      this.publishingHouses = data;
      this.onRender();
    });
  }

  onRender() {
    this.dataBinder.render(this, document.getRootNode());
  }

  onDetectChanges() {
    this.dataBinder.detectChanges(this, document.getRootNode());
  }

  onDelete(publishingHouse) {
    this.publishingHouseService
      .deletePublishingHouse(publishingHouse.id)
      .then(() => {
        let index = this.publishingHouses.publishingHouses.findIndex(
          (item) => item === publishingHouse
        );
        if (index > -1) {
          this.publishingHouses.publishingHouses.splice(index, 1);
          this.onDetectChanges();
        }
      });
  }
}
