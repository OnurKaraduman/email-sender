package com.crossengage.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.crossengage.constants.TextFileConstant;
import com.crossengage.model.User;

public class FileFactory {

	public void save(User user) throws IOException {
		appendToFile(user.toString());
	}

	public List<User> readTextFileAndReturnUsersByState(Boolean state) throws IOException {
		return readFileAndReturn(state);
	}

	private List<User> readFileAndReturn(Boolean state) throws IOException {
		Path path = getFilePath();
		List<User> users = new ArrayList<User>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(path, StandardCharsets.UTF_8.name());
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				StringTokenizer st = new StringTokenizer(line);
				String id = st.nextToken();
				String name = st.nextToken();
				String surname = st.nextToken();
				String email = st.nextToken();
				String activeStr = st.nextToken();
				Boolean active = Boolean.valueOf(activeStr);
				if (state == null) {
					User user = new User(id, name, surname, email, active);
					users.add(user);
				} else {
					if (state) {
						if (active) {
							User user = new User(id, name, surname, email, active);
							users.add(user);
						}
					} else {
						if (!active) {
							User user = new User(id, name, surname, email, active);
							users.add(user);
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return users;
	}

	private void appendToFile(String text) throws IOException {
		FileWriter writer = null;
		BufferedWriter out = null;
		try {
			File file = getFile();
			writer = new FileWriter(file, true);
			out = new BufferedWriter(writer);
			out.write(text);
			out.newLine();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (out != null)
				out.close();
			if (writer != null)
				writer.close();
		}
	}

	private Path getFilePath() {
		return Paths.get(getFilePathString());
	}

	private File getFile() {
		return new File(getFilePathString());
	}

	private String getFilePathString() {
		return TextFileConstant.TEXT_FILE_NAME;
	}
}
