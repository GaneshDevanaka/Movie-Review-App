import React, { useRef } from "react";
import axios from "axios";
import "./MovieForm.css";

const MovieForm = () => {
  const imdbIdRef = useRef(null);
  const titleRef = useRef(null);
  const releaseDateRef = useRef(null);
  const trailerLinkRef = useRef(null);
  const genresRef = useRef(null);
  const posterRef = useRef(null);
  const backdropsRef = useRef(null);

  const handleSubmit = (e) => {
    e.preventDefault();

    const movieData = {
      imdbId: imdbIdRef.current.value,
      title: titleRef.current.value,
      releaseDate: releaseDateRef.current.value,
      trailerLink: trailerLinkRef.current.value,
      genres: genresRef.current.value.split(",").map((genre) => genre.trim()),
      poster: posterRef.current.value,
      backdrops: backdropsRef.current.value
        .split(",")
        .map((backdrop) => backdrop.trim()),
      reviews: [],
    };

    axios
      .post("http://localhost:8080/reviewapp/api/v1/movies", movieData)
      .then((response) => {
        console.log("Movie added:", response.data);

        e.target.reset();
      })
      .catch((error) => {
        console.error("Error adding movie:", error);
      });
  };

  return (
    <div className="form-container">
      <h1>Add New Movie</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>IMDB ID:</label>
          <input
            type="text"
            ref={imdbIdRef}
            required
            placeholder="Enter IMDB ID"
          />
        </div>
        <div className="form-group">
          <label>Title:</label>
          <input
            type="text"
            ref={titleRef}
            required
            placeholder="Enter movie title"
          />
        </div>
        <div className="form-group">
          <label>Release Date:</label>
          <input type="date" ref={releaseDateRef} required />
        </div>
        <div className="form-group">
          <label>Trailer Link:</label>
          <input
            type="url"
            ref={trailerLinkRef}
            placeholder="Enter trailer link (optional)"
          />
        </div>
        <div className="form-group">
          <label>Genres (comma separated):</label>
          <input type="text" ref={genresRef} placeholder="Enter genres" />
        </div>
        <div className="form-group">
          <label>Poster URL:</label>
          <input type="url" ref={posterRef} placeholder="Enter poster URL" />
        </div>
        <div className="form-group">
          <label>Backdrops (comma separated URLs):</label>
          <input
            type="text"
            ref={backdropsRef}
            placeholder="Enter backdrops URLs"
          />
        </div>
        <button type="submit">Add Movie</button>
      </form>
    </div>
  );
};

export default MovieForm;
