package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.dto.BookForm;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createItemForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String bookForm(@Valid BookForm bookForm, BindingResult result) {

        Book book = new Book();

        if(result.hasErrors()) {
            return "items/createItemForm";
        }

        book.setStockQuantity(bookForm.getStockQuantity());
        book.setName(bookForm.getName());
        book.setPrice(bookForm.getPrice());
        book.setAuthor(bookForm.getAuthor());
        book.setIsbn(bookForm.getIsbn());

        itemService.saveItem(book);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String itemList(Model model) {
        List<Item> item = itemService.findItem();
        model.addAttribute("items", item);
        return "items/itemList";
    }

    @GetMapping("/items/{itemId}/edit")
    public String updateBookForm(@PathVariable Long itemId, Model model, BookForm bookForm) {

        Book book = (Book) itemService.findOne(itemId);

        BookForm form = new BookForm();

        // itemId를 악의로 수정할 수 있기에 추후에 운영에서는 롤타입 체크하는 로직이 있어야함.

        form.setId(book.getId());
        form.setName(book.getName());
        form.setPrice(book.getPrice());
        form.setIsbn(book.getIsbn());
        form.setAuthor(book.getAuthor());
        form.setStockQuantity(book.getStockQuantity());

        model.addAttribute("form", form);

        return "items/updateItemForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String updateBookForm(@ModelAttribute("form") BookForm bookForm) {
        Book book = new Book();
        book.setId(bookForm.getId());
        book.setName(bookForm.getName());
        book.setPrice(bookForm.getPrice());
        book.setStockQuantity(bookForm.getStockQuantity());
        book.setAuthor(bookForm.getAuthor());
        book.setIsbn(bookForm.getIsbn());

        itemService.saveItem(book);
        return "redirect:/items";
    }


}
