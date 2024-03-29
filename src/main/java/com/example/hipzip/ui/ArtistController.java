package com.example.hipzip.ui;

import com.example.hipzip.application.ArtistService;
import com.example.hipzip.application.dto.artist.ArtistDetailResponse;
import com.example.hipzip.application.dto.artist.ArtistModifyRequest;
import com.example.hipzip.application.dto.artist.ArtistResponse;
import com.example.hipzip.application.dto.artist.ArtistSaveRequest;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping("/artists")
    public ResponseEntity<Void> save(@RequestBody @Valid ArtistSaveRequest request) {
        Long artistId = artistService.save(request);
        return ResponseEntity.created(URI.create("/artists/"+artistId)).build();
    }

    @GetMapping("/artists")
    public ResponseEntity<List<ArtistResponse>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size
    ) {
        List<ArtistResponse> artistTag = artistService.findAll(page, size);
        return ResponseEntity.ok(artistTag);
    }

    @GetMapping("/artists/search")
    public ResponseEntity<List<ArtistResponse>> findByName(
            @RequestParam(value = "name") String name
    ) {
        List<ArtistResponse> artistTag = artistService.findByName(name);
        return ResponseEntity.ok(artistTag);
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<ArtistDetailResponse> findById(
            @PathVariable Long id
    ) {
        ArtistDetailResponse artistDetail = artistService.findById(id);
        return ResponseEntity.ok(artistDetail);
    }

    @PutMapping("/artists")
    public ResponseEntity<Void> edit(@RequestBody @Valid ArtistModifyRequest request) {
        artistService.edit(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/artists/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        artistService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
