var placeholderImg = "resources/images/placeholder_restaurant_pic.jpg";

var URL = window.location.href; // return full URL with params

$.ajax({
    url: URL,
    type: 'GET',
    dataType: 'json',
    success: function (data, textStatus, jqXHR) {
        var likes = "Total likes: ";
        for (var i = 0; i < data.length; i++) {
            if (data[i].imgUrl == "") {
                data[i].imgUrl = placeholderImg;
            }
            renderHTMLCardsRestaurant(data[i].id, data[i].name, data[i].description, data[i].address, likes + data[i].likesOfRestaurant.length, data[i].imgUrl);
        }
    },
    error: function (a, b, c) {
        console.log('something went wrong:', a, b, c);
    }
});

function renderHTMLCardsRestaurant(id, name, description, address, likes, imgSource) {
    // Constructing html page code
    // Useful guide is here: https://www.youtube.com/watch?v=NboWXuhlqvQ
    let card = document.createElement("div");
    let imageElement = document.createElement("img");
    let cardBody = document.createElement("div");
    let pElementBold = document.createElement("p");
    let pElement = document.createElement("p");
    let voteCounter = document.createElement("p");
    let voteButton = document.createElement("button");
    let showMenuButton = document.createElement("button");

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
    voteCounter.id = id;

   // pElement.id = id; // each likes-counter has its own id
    voteButton.className = "btn btn-info mr-1";
    voteButton.id = "voteBtn";
    voteButton.innerText = "Vote";

    showMenuButton.className = "btn btn-dark";
    showMenuButton.id = "showMenuBtn";
    showMenuButton.innerText = "See Menu";

    voteButton.onclick = function () {
        var like = createLikeOfRestaurantObject(id)
        // check if the user is logged in. Only logged in users can vote
        // Once we hit URL /ifloggedin the UserProfileController returns true or false
        $.ajax({
            url: 'ifloggedin',
            type: 'GET',
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                if (data) {
                    saveLike(like, id, "likes/restaurant/");
                } else {
                    infoNoty("Please log in to vote");
                }
            },
            error: function (a, b, c) {
                console.log('something went wrong:', a, b, c);
            }
        });
    }

    showMenuButton.onclick = function () {
        $('#showMenuModal').modal('show');
        $('#showMenuModalLabel').text("Menu of " + name);

        $.ajax({
            url: 'menus/restaurant/' + id,
            type: 'GET',
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                // There can be many menus in 'data' array;
                debugger;
                let menuText = data[0].description + '<br>' + '===========' + '<br>';
                for (let i = 1; i < data.length; i++) {
                    menuText = menuText + data[i].description + '<br>' + '===========' + '<br>';
                }
                $('#menuDescription').css('whiteSpace', 'pre-wrap'); // preserve linebreaks
                $('#menuDescription').html(menuText);
            },
            error: function (a, b, c) {
                console.log('something went wrong:', a, b, c);
            }
        });
    }

    // the divs that used only once are taken from jsp page, we do not create them here
    // appendChild - adding a tag inside another tag
    document.getElementsByClassName("container-fluid")[0].appendChild(document.getElementsByClassName("card-deck")[0]);
    document.getElementsByClassName("card-deck")[0].appendChild(card);
    card.append(imageElement, cardBody);
    cardBody.append(pElementBold, pElement);
    pElementBold.innerText = name;
    pElement.innerText = description + "\n" + address;
    voteCounter.innerText = likes;
    cardBody.appendChild(voteCounter);
    cardBody.appendChild(voteButton);
    cardBody.appendChild(showMenuButton);
}

function createLikeOfRestaurantObject(restaurantID) {
    var restaurant = {
        id: restaurantID
    }

    var like = {
        restaurant: restaurant
    };
    return like;
}

function updateLikesCounter() {
    $.ajax({
        url: 'restaurants',
        type: 'GET',
        dataType: 'json',
        success: function (data, textStatus, jqXHR) {
            var likes = "Total likes: ";
            for (var i = 0; i < data.length; i++) {
                document.getElementById(data[i].id).innerHTML = likes + data[i].likesOfRestaurant.length;
            }
        },
        error: function (a, b, c) {
            console.log('something went wrong:', a, b, c);
        }
    });
}