package sistemadevagasdeestacionamento

class User {
    String username
    String firstName
    String lastName
    String preferredSector

    static constraints = {
        username nullable: false, blank: false, unique: true
        firstName nullable: false, blank: false, matches: "[a-zA-Z]+"
        lastName nullable: false, blank: false, matches: "[a-zA-Z]+"
        preferredSector inList: ["CIn", "CCEN", "Area II"]
    }
}