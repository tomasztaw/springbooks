/**
 * Created by tomasz_taw
 * Date: 25.10.2023
 * Time: 20:46
 * Project Name: springbooks
 * Description:
 */
package pl.taw.model;

public record Book(Integer id, String title, Integer pages, Rating rating, Author author) {
}
