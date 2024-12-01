import javax.swing.*;
import java.util.ArrayList;

public class Principal {

    // Lista para armazenar as tarefas
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        // Loop principal que exibe o menu de opções até o usuário decidir sair
        while (true) {
            String menu = "Escolha uma ação:\n" +
                    "1. Adicionar nova tarefa\n" +
                    "2. Concluir tarefa\n" +
                    "3. Excluir tarefa\n" +
                    "4. Mostrar todas as tarefas\n" +
                    "5. Sair";

            // Exibe o menu e recebe a opção escolhida pelo usuário
            String choice = JOptionPane.showInputDialog(null, menu);

            // Se o usuário clicar "Cancelar" ou fechar a janela, o programa será encerrado
            if (choice == null) {
                break;
            }

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    completeTask();
                    break;
                case "3":
                    removeTask();
                    break;
                case "4":
                    showTasks();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Até logo! Programa encerrado.");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        }
    }

    // Método para adicionar uma tarefa
    private static void addTask() {
        String taskDescription = JOptionPane.showInputDialog("Digite a descrição da nova tarefa:");
        if (taskDescription != null && !taskDescription.trim().isEmpty()) {
            tasks.add(taskDescription);
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Descrição inválida! A tarefa não pode ser vazia.");
        }
    }

    // Método para concluir uma tarefa
    private static void completeTask() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa para concluir.");
            return;
        }

        String taskList = listTasksForCompletion();
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa pendente.");
            return;
        }

        String taskIndex = JOptionPane.showInputDialog("Escolha o número da tarefa que deseja concluir:\n" + taskList);
        try {
            int index = Integer.parseInt(taskIndex);
            if (index >= 0 && index < tasks.size()) {
                String completedTask = tasks.get(index) + " (Concluída)";
                tasks.set(index, completedTask);
                JOptionPane.showMessageDialog(null, "Tarefa concluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido! A tarefa não foi encontrada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido! Tente novamente.");
        }
    }

    // Método para remover uma tarefa
    private static void removeTask() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas para remover.");
            return;
        }

        String taskList = listTasksForRemoval();
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa disponível para remoção.");
            return;
        }

        String taskIndex = JOptionPane.showInputDialog("Escolha o número da tarefa que deseja excluir:\n" + taskList);
        try {
            int index = Integer.parseInt(taskIndex);
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido! A tarefa não foi encontrada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido! Tente novamente.");
        }
    }

    // Método para mostrar todas as tarefas
    private static void showTasks() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você não tem tarefas cadastradas.");
            return;
        }

        String taskList = listTasksForCompletion();
        JOptionPane.showMessageDialog(null, "Tarefas atuais:\n" + taskList);
    }

    // Método auxiliar para formatar as tarefas para exibição
    private static String listTasksForCompletion() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i).append(" - ").append(tasks.get(i)).append("\n");
        }
        return sb.toString();
    }

    // Método auxiliar para formatar as tarefas para remoção
    private static String listTasksForRemoval() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i).append(" - ").append(tasks.get(i)).append("\n");
        }
        return sb.toString();
    }
}
