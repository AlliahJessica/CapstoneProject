package com.example.caps;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Predefined list of ticket numbers (replace this with your SQL logic later)
    private final List<Long> ticketNumbers = Arrays.asList(123456L, 654321L, 789012L);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        EditText ticketNumberInput = findViewById(R.id.ticketNumberInput);
        Button checkTicketButton = findViewById(R.id.checkTicketButton);
        TextView ticketResult = findViewById(R.id.ticketResult);

        // Set up click listener for the button
        checkTicketButton.setOnClickListener(v -> {
            String inputText = ticketNumberInput.getText().toString();

            // Check if the input is not empty
            if (!inputText.isEmpty()) {
                long inputTicketNumber = Long.parseLong(inputText);

                // Check if the entered ticket number exists in the list
                if (ticketNumbers.contains(inputTicketNumber)) {
                    // Add details for the specific ticket number
                    if (inputTicketNumber == 123456L) {
                        ticketResult.setText("Ticket number: 123456\nOwner: John Doe\nEvent: Concert A\nDate: 15th October 2024\nStatus: Valid");
                    } else if (inputTicketNumber == 654321L) {
                        ticketResult.setText("Ticket number: 654321\nOwner: Jane Smith\nEvent: Movie Premiere\nDate: 20th October 2024\nStatus: Valid");
                    } else if (inputTicketNumber == 789012L) {
                        ticketResult.setText("Ticket number: 789012\nOwner: Bob Johnson\nEvent: Theatre Play\nDate: 25th October 2024\nStatus: Valid");
                    } else {
                        ticketResult.setText("Ticket number found: " + inputTicketNumber);
                    }
                } else {
                    ticketResult.setText("Error: Ticket number not found.");
                }
            } else {
                ticketResult.setText("Error: Please enter a ticket number.");
            }
        });
    }
}
