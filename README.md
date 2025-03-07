private static void writeTemplateData(Sheet sheet, AttestationHierarchicalTemplate template, AtomicInteger rowIndex) {
    Row row = sheet.createRow(rowIndex.getAndIncrement());

    Cell controlTypeCell = row.createCell(12);
    
    // Skip processing if it is a child of "TEXTBOX"
    if (isChildOfTextBox(template)) {
        return; // Skip updating
    }

    if (template.getControlType().equalsIgnoreCase("textbox")) {
        // Continue to processing if TEXTBOX itself
    } else if (template.getControlType().equalsIgnoreCase("display")) {
        controlTypeCell.setCellValue("Display");
    } else if (template.getControlType().equalsIgnoreCase("CHECKBOX") && !template.getChildren().isEmpty()) {
        for (AttestationHierarchicalTemplate child : template.getChildren()) {
            if (child.getControlType().equalsIgnoreCase("textbox")) {
                controlTypeCell.setCellValue("Check Box (Bounded)");
                break;
            }
        }
    } else {
        controlTypeCell.setCellValue(template.getControlType());
    }

    Cell controlTypeCell13 = row.createCell(11);
    controlTypeCell13.setCellValue(rowIndex.get());

    Cell controlTypeCell12 = row.createCell(10);
    controlTypeCell12.setCellValue(template.getControlType());

    Cell controlTypeCell14 = row.createCell(9);
    controlTypeCell14.setCellValue(template.getIdentifier()); // column K
}

// Helper function to check if the element is a child of TEXTBOX
private static boolean isChildOfTextBox(AttestationHierarchicalTemplate template) {
    AttestationHierarchicalTemplate parent = template.getParent();
    while (parent != null) {
        if (parent.getControlType().equalsIgnoreCase("textbox")) {
            return true; // It is a child of a TEXTBOX
        }
        parent = parent.getParent();
    }
    return false;
}
