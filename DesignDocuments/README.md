# Design Documents

You may have multiple design documents for this project. Place them all in this folder. File naming is up to you, but it should be clear what the document is about. At the bare minimum, you will want a pre/post UML diagram for the project. 

####  Final UML (draft)
```mermaid
classDiagram

%% === INTERFACES ===
class IController {
  <<interface>>
  + start(): void
  + handleSearch(String: value, Operations: op, FilterType: filterType): void
  + handleFilter(String: filter, String: operator, String: value): void
  + handleSort(FilterType: filterType, boolean: ascending): void
  + handleAddMovie(String: movieTitle): void
  + handRemoveMovie(String: movieTitle): void
  + handleSave(String: fileType): void
}
class IMovieCollection {
  <<interface>>
  +getMovies(): List~Movie~
  +getFilteredMovies(String: value, Operations: op, FilterType: filterType): List~Movie~`
  +getInstance(): IMovieCollection
  +reset(): void
}
class IMovieFilter {
    <<interface>>
    filter(List~Movie~ movieList, Operations: op, FilterType: filterType, String: value) : Stream~Movie~
}
class IMovieList {
  <<interface>>
  +getMovieTitles(): List~String~
  +getMovies(): List~Movie~
  +add(Movie: movie): void
  +addAll(List~Movie~: movies): void
  +remove(Movie: movie): void
  +removeAll(List~Movie~: movies): void
  +clear(): void
  +size(): int
}
class IMovieSort {
    <<interface>>
  +sort(List~Movie~: filteredMovieList, FilterType: filterType): List~Movie~
  +sort(List~Movie~: filteredMovieList, FilterType: filterType, boolean: ascending): List~Movie~
}
class IView {
  <<interface>>
  +setVisible(boolean: visible): void
  +viewMovieCollection(List~Movie~: movies): void
  +viewMovieList(List~Movie~: movies): void
  +showErrorMessage(String: errorMessage): void
  +showHelpMessage(String: helpMessage): void
  +getSearchQuery(): String
  +getSelectedFilter(): String
  +getSelectedOperator(): String
  +getSort(): boolean
  +addFilterListener(ActionListener: listener): void
  +addSortListener(ActionListener: listener): void
  +addAddMovieListener(ActionListener: listener): void
  +addRemoveMovieListener(ActionListener: listener): void
  +addSaveListener(ActionListener: listener): void
  +addHelpListener(ActionListener: listener): void
}


%% === MODELS ===
class Movie {
  -title: String
  -year: int
  -genre: List~String~
  -cast: List~String~
  -description: String
  -imageUrl:String
  +getters/setters()
  +equals(Object: o): boolean
  +hashCode(): int
  +toString(): String
}
class ListOfStringDeserializer{
  +deserialize(JsonParser: jp, DeserializationContext: ctxt): List~String~
}
class ListOfStringSerializer {
    +serialize(ArrayList~String~: list, JsonGenerator: jsonGenerator, SerializerProvider: serializer): void
}
class MovieCollection {
  -movieRecords: Set~Movie~
  +filteredMovieList: List~Movie~
}
class MovieList {
  -movies:Set~Movie~
}
class MovieStorage {
  -DATABASE: String
  -DEFAULT_OUTPUT_LOCATION: String
  +readJSON(InputStream: inputStream): List~Movie~
  +loadDatabase(): List~Movie~
  +writeJsonData(Set~Movie~ movies): void
}


%% === STORAGE / API ===
class MovieStorage {
  +saveToFile()
  +loadFromFile()
}
class OMDBMovieData {
  -API_URL_FORMAT_TITLE: String
  -API_URL_FORMAT_YEAR: String
  -API_KEY: String
  +getApiUrl(String: title): String
  +getUrlContents(String: urlStr): InputStream
  +getMovieDetails(String: title): InputStream
}

%% === CONTROLLER ===
class MovieApp {
  +main(String[] args)
}
class MovieController {
  -model: IMovieCollection
  -userList: IMovieList
  -view: IView
  -results: List<Movie>
  +getResults(): List<Movie>
}

%% === VIEW ===
class ButtonCommands
class JFrameView
class MovieCardPanel
class MovieDisplay
class MovieGridDisplay
class UserMovieListPanel

%% === UTILITIES ===
class MovieFilter {
  +filterByTitle(List~Movie~: movieList, Operations: op, String: title): Stream~Movie~
  filterByGenre(List~Movie~: movieList, Operations: op, String: genre): Stream~Movie~
  filterByDesc(List~Movie~: movieList, Operations: op, String: desc): Stream~Movie~ 
  filterByYear(List~Movie~: movieList, Operations: op, int: value): Stream~Movie~
}
class MovieSort {
  
}

%% === ENUMS ===
class Operations {
  <<enum>>
  +EQUALS
  +NOT_EQUALS
  +GREATER_THAN
  +LESS_THAN
  +GREATER_THAN_EQUAL
  +LESS_THAN_EQUAL
  +CONTAINS
}
class FilterType{
  <<enum>>
  +GENRE
  +RATING
  +YEAR
  +TITLE
  +DESCRIPTION
  +containsValues(String: value): FilterType
}

%% === RELATIONSHIPS ===
IView <|.. JFrameView : implements
MovieApp --> MovieController : "starts"
MovieList --> Movie : "contains"
MovieCollection ..|> IMovieCollection : "implements"
MovieCollection --> Movie : "manages"
MovieList ..|> IMovieList : "implements"
IController <|.. MovieController : "implements"
MovieController --> MovieCollection : "uses"
MovieController --> MovieList : "uses"
JFrameView --> MovieController : "interacts with"
JFrameView --> MovieDisplay : "uses"
JFrameView --> ButtonCommands : "uses"
JFrameView --> MovieGridDisplay : "displays"
MovieGridDisplay --> MovieCardPanel: "contains"
JFrameView --> UserMovieListPanel : "displays"
Movie --> ListOfStringDeserializer : uses
Movie --> ListOfStringSerializer : uses


```