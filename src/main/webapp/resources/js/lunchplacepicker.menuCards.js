var imgSource = "resources/images/placeholder_menu_pic.jpg";

var URL = window.location.href; // return full URL with params

$.ajax({
    url: URL,
    type: 'GET',
    dataType: 'json',
    success: function (data, textStatus, jqXHR) {
        var likes = "Total likes: ";
        for (var i = 0; i < data.length; i++) {
            renderHTMLCardsMenus(data[i].id, data[i].description, likes + data[i].likesOfMenu.length, imgSource);
        }
    },
    error: function (a, b, c) {
        console.log('something went wrong:', a, b, c);
    }
});

function renderHTMLCardsMenus(id, description, likes, imgSource) {
    // Constructing html page code
    // Useful guide is here: https://www.youtube.com/watch?v=NboWXuhlqvQ
    let card = document.createElement("div");
    let imageElement = document.createElement("img");
    let cardBody = document.createElement("div");
    let pElementBold = document.createElement("p");
    let pElement = document.createElement("p");
    let voteButton = document.createElement("button");

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
    pElement.id = id; // each likes-counter has its own id
    voteButton.className = "btn btn-info";
    voteButton.id = "voteBtn";
    voteButton.innerText = "Vote";

    voteButton.onclick = function () {
        var like = createLikeOfMenuObject(id)
        // check if the user is logged in. Only logged in users can vote
        // Once we hit URL /ifloggedin the UserProfileController returns true or false
        $.ajax({
            url: 'ifloggedin',
            type: 'GET',
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                if (data) {
                    saveLike(like, id, "likes/menu/");
                } else {
                    infoNoty("Please log in to vote");
                }
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
    pElementBold.innerText = description;
    pElement.innerText = likes + "\n";
    cardBody.appendChild(voteButton);
}

function createLikeOfMenuObject(menuID) {
    var menu = {
        id: menuID
    }

    var like = {
        menu: menu
    };
    return like;
}

function updateLikesCounter() {
    $.ajax({
        url: 'menus',
        type: 'GET',
        dataType: 'json',
        success: function (data, textStatus, jqXHR) {
            var likes = "Total likes: ";
            debugger;
            for (var i = 0; i < data.length; i++) {
                document.getElementById(data[i].id).innerHTML = likes + data[i].likesOfMenu.length;
            }
        },
        error: function (a, b, c) {
            console.log('something went wrong:', a, b, c);
        }
    });
}