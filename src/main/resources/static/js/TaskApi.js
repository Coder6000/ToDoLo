export class TaskApi {
    async getTasks() {
        const response = await fetch("/tasks");

        if (!response.ok) {
            alert("Could not load tasks!");
            return;
        }

        const tasks = await response.json();
        return tasks;
    }
    async createTask(task){
        await fetch("/tasks", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                task: task
            }),
        })
    }

    async deleteTask(selectedTaskId) {
        await fetch("/tasks/" + selectedTaskId, {
            method: "DELETE",
        });
    }
}