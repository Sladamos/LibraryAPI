export class PublishingHouseService {
  getPublishingHouses() {
    return fetch("http://localhost:8084/api/publishing-houses").then(
      (response) => {
        if (response.ok) {
          return response.json();
        }
        throw new Error("Network error.");
      }
    );
  }

  deletePublishingHouse(id) {
    return fetch("/api/publishing-houses/" + id, {
      method: "DELETE",
    }).then((response) => {
      if (response.ok) {
        return;
      }
      throw new Error("Network error.");
    });
  }

  getPublishingHouse(id) {
    return fetch("/api/publishing-houses/" + id).then((response) => {
      if (response.ok) {
        return response.json();
      }
      throw new Error("Network error.");
    });
  }

  putPublishingHouse(id, request) {
    return fetch("/api/publishing-houses/" + id, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(request),
    }).then((response) => {
      if (response.ok) {
        return;
      }
      throw new Error("Network error.");
    });
  }

  patchPublishingHouse(id, request) {
    return fetch("/api/publishing-houses/" + id, {
      method: "PATCH",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(request),
    }).then((response) => {
      if (response.ok) {
        return;
      }
      throw new Error("Network error.");
    });
  }
}
