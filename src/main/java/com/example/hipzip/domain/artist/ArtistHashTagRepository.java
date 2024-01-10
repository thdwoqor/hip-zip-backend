package com.example.hipzip.domain.artist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistHashTagRepository extends JpaRepository<ArtistHashTag, Long> {
    void deleteAllByArtist_Id(Long id);
}
