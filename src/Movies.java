public class Movies {
    private String name;
    private Integer movieLength;
    private String genre;
    private Integer schedule;

//==============================================================================================================================
    public Movies(String name, Integer movieLength, String genre, Integer schedule) {
        this.name = name;
        this.movieLength = movieLength;
        this.genre = genre;
        this.schedule = schedule;
    }

//==============================================================================================================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(Integer movieLength) {
        this.movieLength = movieLength;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }
}
