package uz.saidarabxon.chatsapp.models

class User {
    var displayName: String = ""
    var imageLink: String = ""
    var uid: String = ""


    constructor()

    constructor(displayName: String, imageLink: String, uid: String) {
        this.displayName = displayName
        this.imageLink = imageLink
        this.uid = uid
    }

}

