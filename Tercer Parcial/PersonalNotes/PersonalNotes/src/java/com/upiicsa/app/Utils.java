package com.upiicsa.app;

import com.upiicsa.models.Note;
import java.util.ArrayList;

/**
 *
 * @author Rayas Batalla Luis A.
 */
public class Utils {
    public static String getUsername(int id) {
        try {
            var connection = new DatabaseConnection();
            String query = "SELECT `username` FROM `user` WHERE `id` = ?;";

            String username = "";

            var result = connection.executeQuery(query, id);

            while (result.next()) {
                username = result.getString(1);
            }
            
            return username;
        } catch (java.sql.SQLException ex) {
            System.out.println(ex.getCause());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getCause());
        }
        
        return null;
    }
    
    public static ArrayList<Note> getNotes(int id) {
        try {
            var connection = new DatabaseConnection();
            String query = "SELECT `id`, `text`, `created_at` AS `createdAt`, `updated_at` AS `updatedAt` FROM `note` WHERE `user_id` = ?;";
            
            var result = connection.executeQuery(query, id);
            
            ArrayList<Note> notes = new ArrayList<>();

            while (result.next()) {
                Note note = new Note();
                
                note.setId(result.getInt(1));
                note.setText(result.getString(2));
                note.setCreatedAt(result.getDate(3));
                note.setUpdatedAt(result.getDate(4));
                
                notes.add(note);
            }
            
            return notes;
        } catch (java.sql.SQLException ex) {
            System.out.println(ex.getCause());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getCause());
        }
        
        return null;
    }
}
