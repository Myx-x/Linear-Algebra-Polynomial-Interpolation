public void bacaMatriksFile() throws Exception {
        Scanner input_file = new Scanner(System.in);
        System.out.println("Masukkan nama file");
        String nama_file = input_file.next(); 
        File file = new File(nama_file); 
        Scanner line = new Scanner(file);
        Scanner word = new Scanner(file);
        Scanner sc = new Scanner(file);
        int i = 0;
        int j = 0;
        int count_line = 0;
        int count_word = 0;
        while (line.hasNextLine()){
            count_line++;
            line.nextLine();
        }
        while(word.hasNextLine()){
            count_word++;
            word.next();
        }
        int row = count_line;
        int column = count_word/count_line;
        makeMatrix(row,column);
        while (sc.hasNextLine()){
            String k = sc.next();
            double m = Double.parseDouble(k);
            this.Y[i][j] = m;
            j++;
            if(j >= column){
                i++;
                j = 0;
            }
        }
    }