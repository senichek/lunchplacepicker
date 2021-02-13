var imgSource = "resources/images/placeholder_restaurant_pic.jpg";

$.ajax({
    url: 'restaurants',
    type: 'GET',
    dataType: 'json',
    success: function (data, textStatus, jqXHR) {
        for (var i = 0; i < data.length; i++) {
            renderHTMLCardsRestaurant(data[i].name, data[i].description, data[i].address, imgSource);
        }
    },
    error: function (a, b, c) {
        console.log('something went wrong:', a, b, c);
    }
});

function renderHTMLCardsRestaurant(name, description, address, imgSource) {
    // Constructing html page code
    // Useful guide is here: https://www.youtube.com/watch?v=NboWXuhlqvQ
    let card = document.createElement("div");
    let imageElement = document.createElement("img");
    let cardBody = document.createElement("div");
    let pElementBold = document.createElement("p");
    let pElement = document.createElement("p");

    card.className = "card";
    card.style = "min-width: 18rem";
    imageElement.className = "card-img-top";
    imageElement.src = imgSource;
    // alt attribute specifies an alternate text for an image, if the image cannot be displayed.
    imageElement.alt = "Card image cap";
    cardBody.className = "card-body";
    pElementBold.className = "card-text-bold";
    pElementBold.style = "font-weight: bold;";
    pElement.className = "card-text";

    // the divs that used only once are taken from jsp page, we do not create them here
    // appendChild - adding a tag inside another tag
    document.getElementsByClassName("container-fluid")[0].appendChild(document.getElementsByClassName("card-deck")[0]);
    document.getElementsByClassName("card-deck")[0].appendChild(card);
    card.append(imageElement, cardBody);
    cardBody.append(pElementBold, pElement);
    pElementBold.innerText = name;
    pElement.innerText = description + "\n";
    pElement.append(address);
}

