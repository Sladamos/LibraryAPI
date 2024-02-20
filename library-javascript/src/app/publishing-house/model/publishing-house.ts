export class PublishingHouse {
  id: String = '';
  name: String = '';
  creationYear: number = 0;

  constructor(id?: String, name?: String, creationYear?: number) {
    if (id) this.id = id;
    if (name) this.name = name;
    if (creationYear) this.creationYear = creationYear;
  }
}
